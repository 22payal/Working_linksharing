package linksharing

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

    static transients = ['name','confirmPassword']

    static constraints = {
        email(email: true,unique: true ,blank: false , nullable: false)
        password(minSize: 5, blank: false ,nullable: false,validator: {password, obj ->
            def password2 = obj.confirmPassword
            password == password2 ? true : ['invalid.matchingpasswords']
        })
        firstName(blank: false ,nullable: false)
        lastName(blank: false , nullable: false)
        userName(unique: true, blank:false , nullable: false)
        photo(nullable: true,sqlType:'longBlob')
        admin(nullable:true)
        active(nullable: true)
        confirmPassword(nullable: false,blank: false)

    }

    static mapping = {
        sort 'id':'desc'
    }




    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
