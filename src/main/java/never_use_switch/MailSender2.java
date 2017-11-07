package never_use_switch;


import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class MailSender2 {

    private Map<Integer, Class<? extends MailGenerator>> mailGenerators = new HashMap<>();

    public MailSender2() {
        Reflections scanner = new Reflections("never_use_switch");
        Set<Class<? extends MailGenerator>> classes = scanner.getSubTypesOf(MailGenerator.class);
        for (Class<? extends MailGenerator> aClass : classes) {
            if (!Modifier.isAbstract(aClass.getModifiers())) {
                //I have added MailCode annotation to all MailGenerator classes so we could get their main code
                MailCode annotation = aClass.getAnnotation(MailCode.class);
                mailGenerators.put(annotation.value(), aClass);
            }
        }
    }

    public void sendMail(MailInfo mailInfo) {
        //get MailGenerator class from it`s mail code
        Class<? extends MailGenerator> mailGeneratorClass = mailGenerators.get(mailInfo.getMailCode());

        MailGenerator mailGenerator;
        try {
            //create mail generator instance
            mailGenerator = mailGeneratorClass.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(mailInfo.getMailCode() + " not supported yet");
        }

        String html = mailGenerator.generateHtml(mailInfo);
        send(html,mailInfo);
    }

    private void send(String html, MailInfo mailInfo) {
        System.out.println("sending to ... " + html);
    }


}
