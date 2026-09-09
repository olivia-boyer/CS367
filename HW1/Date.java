public class Date {
   private int year;
   private int month;
   private int day;
   
    public void setYear(int setto) {
        year = setto;
    }

    public void setMonth(int setto) {
        month = setto;
    }

    public void setDay(int setto) {
        day = setto;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    //check if date is real
    public boolean isValid() {
        //invalid month
        if (this.month > 12 || this.month < 1) {
            return false;
        }

        //universal invalid day
        if (this.day > 31 || this.day < 1) {
            return false;
        }

        //invalid day for shorter months
        if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
            return (this.day <= 30);
        }

        //february
        if (this.month == 2) {

            //assume is leap year
            if (this.day > 29) {
                return false;
            }

            //check if not leap year
            if (this.year % 4 == 0) {
                if (this.year % 100 == 0) {
                    if(this.year % 400 == 0) {
                        //is leap year
                        return true;
                    }
                    //not leap year
                    return (this.day <= 28); 
                }
                //is leap year
                return true;
            } else {
                //not leap year
                return this.day <= 28;
            }

        }
        return true;
    }
    
}
