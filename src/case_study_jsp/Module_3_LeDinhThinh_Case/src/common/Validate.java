package common;

public class Validate {

    public static String validateName(String name){
        String message = null;
        String regex = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$";
        if(!name.matches(regex)){
            message ="Not OK.Name invalid";
        }
        return message;
    }
    public static String validateCusId(String id){
        String message = null;
        String regex = "^(KH)-\\d{4}$";
        if(!id.matches(regex)){
            message ="Not OK.ID invalid";
        }
        return message;
    }
    public static String validateSerId(String id){
        String message = null;
        String regex = "^(DV)-\\d{4}$";
        if(!id.matches(regex)){
            message ="Not OK.ID invalid";
        }
        return message;
    }
    public static String validateEmId(String id){
        String message = null;
        String regex = "^(NV)-\\d{4}$";
        if (!id.matches(regex)){
            message = "Not OK.ID invalid";
        }
        return message;
    }
    public static String validatePhone(String phone){
        String message = null;
        String regex = "^0[1-9]{1}[0-9]{8}$";
        if(!phone.matches(regex)){
            message ="Not OK.Phone invalid";
        }
        return message;
    }
    public static String validateIdCard(String id_card){
        String message = null;
        String regex = "^\\d{9}$";
        if(!id_card.matches(regex)){
            message ="Not OK.Id card invalid";
        }
        return message;
    }
    public static String validateEmail(String email){
        String message = null;
        String regex ="^((?!\\.)[\\w-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$";
        if(!email.matches(regex)){
            message ="Not OK.Email invalid";
        }
        return message;
    }
    public static String validateDate(String date){
        String message = null;
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        if(!date.matches(regex)){
            message ="Not OK.Date invalid";
        }
        return message;
    }
    public static String validateAmount(String amount){
        String message = null;
        String regex = "^[\\d]+$";
        if(!amount.matches(regex)){
            message ="Not OK.Amount invalid";
        }
        return message;
    }
}
