public class ParseDate {
    public static Date parseDate(String dateString) throws IllegalArgumentException {
        Date retval = new Date();
        //check string length
        if (dateString.length() != 10) {
            throw new IllegalArgumentException("Incorrect length. Use format YYYY-MM-DD");
        }

        //read in year
        char c = 0;
        int year = 0;
        for (int i = 0; i < 4; i++) {
            c = dateString.charAt(i);
            //from StringToInteger
            if (c >= '0' && c <= '9') {
                year = year * 10 + (c - '0');
            } else {
                throw new IllegalArgumentException("Invalid character found in year: " + c);
            }
        }
        retval.setYear(year);

        //check for '-' character
        c = dateString.charAt(4);
        if (c != '-') {
           throw new IllegalArgumentException("Invalid character found: " + c + " Expected: '-'"); 
        }

        //read in month
        //note: requires input string to use leading zeros
        int month = 0;
        for (int i = 5; i < 7; i++) {
            c = dateString.charAt(i);
            //from StringToInteger
            if (c >= '0' && c <= '9') {
                month = month * 10 + (c - '0');
            } else {
                throw new IllegalArgumentException("Invalid character found in month: " + c);
            }
        }
        retval.setMonth(month);

        //check for second '-'
        c = dateString.charAt(7);
        if (c != '-') {
           throw new IllegalArgumentException("Invalid character found: " + c + " Expected: '-'"); 
        }

        //read in day
        int day = 0;
        for (int i = 8; i < 10; i++) {
            c = dateString.charAt(i);
            //from StringToInteger
            if (c >= '0' && c <= '9') {
                day = day * 10 + (c - '0');
            } else {
                throw new IllegalArgumentException("Invalid character found in day: " + c);
            }
        }
        retval.setDay(day);
     
        //read month using string to integer 
        //if month == 12 throw error
        //check for '-'
        //read day
        //if day == 0 or day > 31 throw error
        return retval;
    }
}


