package Email;

public class RandomGenerator {
    public static String generateId(){
        StringBuilder tempStr = new StringBuilder();
        String usedChars = "~`!@#$%^&*()_+-=/<>?.,abcdefghijklmnopqrsktuvwsyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for(int i = 0; i < 10; i++)
            tempStr.append(usedChars.charAt((int) Math.floor(Math.random() * usedChars.length() * i)));
        return tempStr.toString();
    }
}
