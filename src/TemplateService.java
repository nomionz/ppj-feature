public class TemplateService {
    String getTemplate(String language) throws InterruptedException {
        Utils.randomSleep();
        return STR."Template for language: \{language}";
//        throw new InterruptedException("Template service is down!");
    }
}
