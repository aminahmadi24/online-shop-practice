package ir.aminahmadi24.utility;

public class Validator {
    public static boolean isNameValid(String name){
        if(name == null || name.length() < 3)
            return false;
        for (int i = 0; i < name.length(); i++) {
            if(Character.isDigit(name.charAt(i)))
                return false;
        }
        return true;
    }
    public static boolean isEmailValid(String email){
        if(email.length() < 6)
            return false;
        boolean hadAtSign = false;
        boolean hasDot = false;
        for (int i = 0; i < email.length(); i++) {
            if(email.charAt(i) == '@')
                hadAtSign = true;
            if(email.charAt(i) == '.')
                hasDot = true;
        }
        return hasDot && hadAtSign;
    }
    public static boolean isPasswordValid(String password){
        if(password == null || password.length() < 8)
            return false;
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = hasSpecialCharacter(password);
        for (int i = 0; i < password.length(); i++) {
            if(Character.isUpperCase(password.charAt(i)))
                hasUppercase = true;
            else if(Character.isLowerCase(password.charAt(i)))
                hasLowercase = true;
            else if(Character.isDigit(password.charAt(i)))
                hasDigit = true;
        }
        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }
    public static boolean isAddressValid(String address){
        if(address.length() < 3)
            return false;
        return true;
    }
    private static boolean hasSpecialCharacter(String password){
        char[] specialChars = {'!', '@', '#', '$', '%', '^', '&', '*'};
        for (int i = 0; i < password.length(); i++) {
            for (char specialChar : specialChars) {
                if (password.charAt(i) == specialChar)
                    return true;
            }
        }
        return false;
    }
}

