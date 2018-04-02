package linksharing

import co.SearchCo

class User {

    String firstName
    String lastName
    String userName
    String password
    String email
    Boolean admin
    Boolean active
    Date dateCreated
    Date lastUpdated
    Byte photo

    static hasMany = [topic:Topic]

   // List<Topic> topics

    String name
    String confirmPassword

    String  getName() {
        name= firstName+" "+lastName
    }

    public String getConfirmPassword(){
        return confirmPassword
    }
    public void setConfirmPassword(String pass){
        confirmPassword = pass
    }

    static transients = ['name','confirmPassword']

    static constraints = {
        email(email: true,unique: true ,blank: false , nullable: false)
        password(minSize: 5, blank: false ,nullable: false)

          confirmPassword(nullable:false, validator: {password, obj ->
            def password2 = obj.confirmPassword
            password == password2 ? true : ['invalid.matchingpasswords']
        })
        firstName(blank: false ,nullable: false)
        lastName(blank: false , nullable: false)
        userName(unique: true, blank:false , nullable: false)
        photo(nullable: true,sqlType:'longBlob')
        admin(nullable:true)
        active(nullable: true)
        confirmPassword(nullable: true,blank: true)

    }

    static mapping = {
        sort 'id':'desc'
    }

    List<ReadingItem> getUnReadResources(SearchCo searchCO){

                List<ReadingItem> unReadItems= ReadingItem.createCriteria().list(max:10,offset:0){
                    eq('isRead',false)
                         eq('user',this)
                         if(searchCO.q){
                                    ilike('resource.description',"%searchCO.q%")
                            }
                    }
           }



    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
