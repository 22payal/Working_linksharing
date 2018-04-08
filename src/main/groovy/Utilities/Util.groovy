package Utilities

class Util {
     static  getRandomPassword()
     {
         Random rnd = new Random();
         int randomPassword = 100000 + rnd.nextInt(900000)
     }
}
