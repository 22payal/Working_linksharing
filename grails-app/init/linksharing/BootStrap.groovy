package linksharing

import enumeration.Seriousness
import enumeration.Visibility


class BootStrap {
//
//    def init = { servletContext ->
//
//    }
//    def destroy = {
//    }

//
//
//    def init = { servletContext ->
//        log.info("**********************************************")
//        println(Holders.grailsApplication.config.server.contextPath)
//    }

//
//    def destroy = {
//    }
//
//}
    def init = { servletContext ->

//        List<User> users = createUsers()

        //Q3
//
//        log.info("Admin is valid- ${users.first().validate()}")
//        log.info("Admin has errors while validating- ${users.first().hasErrors()}")
//
//        log.info("User is valid- ${users.last().validate()}")
//        log.info("User has errors while validating- ${users.last().hasErrors()}")

        //Q4

        if (User.count() == 0) {
            println("Creating Users")
            createUsers()
            println("Done Creating Users")
        }
        println("Creating Topic")
        createTopic()
        println("Done Creating Topic")

        println("Creating Resource")
          createResource()
        println("done Creating Resource")

        println("Creating subscribe topic")
       subscribeTopic()
        println("done Creating subscribe topic")

        println("Creating reading item")
        createReadingItem()
        println("done Creating reading item")

        println("Creating resource rating")
        createResourceRatings()
        println("done Creating resource rating")

    }
    def destroy = {
    }

    List<User> createUsers() {


        List<User> users = []

        User admin = new User(
                firstName:"Payal",
                lastName:"Nigam",
                userName:"payal.nigam",
                password:"payal123",
                email: "payal.nigam@tothenew.com",
                admin:true,
                active: true)

        // admin.topics = []

        /*  Q1
        if(admin.validate()){
            admin.save()
            users.add(admin)
            }
        */

        //Q2
        if (admin.validate()) {
            if (admin.hasErrors()) {
                println(admin.errors)
            }
            admin.save(flush: true, failOnError: true)
            users.add(admin)
        }

        User normal = new User(
                firstName:"test user",
                lastName:  "first",
                userName:  "user.first",
                password:  "first123",
                email:  "test.first@tothenew.com",
                admin:false,
                active: true)


        // normal.topics = []

        /* Q1
        if(normal.validate()){
            normal.save()
            users.add(normal)
            }
        */

        //Q2
        if (normal.validate()) {
            if (normal.hasErrors()) {
                println(normal.errors)
            }
            normal.save(flush: true, failOnError: true)
            users.add(normal)
        }

        return users
    }


    def createTopic() {

        List<User> allusers = User.findAll()
        println(allusers)

        allusers.each
                { user ->
                    println(user)
                    if (!(Topic.findByCreatedBy(user)))
                    {
                        5.times { topicCount ->
                            user.refresh()
                            println("Creating topic for user $user with name topic $topicCount")
                            Topic topic = new Topic(topicName:  "topic $topicCount", visibility: Visibility.PRIVATE, createdBy: user)
                            topic.validate()
                            if(topic.hasErrors()) {
                                println topic.errors
                            }
                            topic.save(flush: true, failOnError: true)
                        }
                        //   user.save(flush: true, failonerror: true)
                    }

                    user.save(flush: true, failonerror: true)
                }

    }


    void createResource() {
        if (Resource.count == 0) {
            List<Topic> allTopics = Topic.getAll()


            allTopics.each {
                Topic temp = it

                (1..2).eachWithIndex { index, item ->

                    LinkResource linkResource = new LinkResource(
                            createdby: temp.createdBy,
                            description: "This link resource with index $index is created by ${temp.createdBy.name} for topic ${temp.topicName}",
                            topic: temp,
                            url: "www.${temp.createdBy.name}.com/${temp.topicName}/${it}")

                    if (linkResource.save(flush: true)) {
                        temp.addToResource(linkResource)
                       // temp.createdBy.addToResource(linkResource)
                        temp.save(flush: true)

                        log.info("Saved Successfully : $linkResource")
                    } else
                        log.error("Error while saving : $linkResource")

                }
                // temp.save(flush: true)
                (1..2).eachWithIndex
                        {
                            index, item ->
                                DocumentResource documentResource = new DocumentResource(
                                        createdBy: temp.createdBy,
                                        description: "This document resource with index $index is created by ${temp.createdBy.name} for topic ${temp.topicName}",
                                        topic: temp,
                                        filepath: "/${temp.createdBy.name}/${temp.topicName}/${it}")

                                if (documentResource.save(flush: true)) {
                                    temp.addToResource(documentResource)
                         //           temp.createdBy.addToResource(documentResource)
                                    temp.save(flush: true)
                                    log.info("Saved Successfully : $documentResource")
                                } else
                                    log.error("Error while saving : $documentResource")
                        }
                //temp.save(flush: true)
            }

        }
    }

    void subscribeTopic() {

        List<User> userList = User.findAll()
        List<Topic> topicList = Topic.findAll()

        userList.each {
            User temp = it
            for (Topic topic : topicList) {
                if (topic.createdBy != temp) {
                    if (!Subscription.findByUserAndTopic(temp, topic)) {
                        Subscription subscription = new Subscription(user: temp, topic: topic, seriousness: Seriousness.VerySerious)
                        if (!subscription.save(flush: true)) {
                            log.error("Error while saving : $subscription")
                        } else {
                            log.info("Saved Successfully : $subscription")
                           // temp.addToSubscription(subscription)
                            //topic.addToSubscription(subscription)
                        }
                    }
                }
            }
        }
    }

        void createReadingItem() {
        List<Subscription> subscriptionList = Subscription.findAll()
        List<User> userList = User.findAll()

            subscriptionList.each {
                for (User user : userList) {
                    if (it.user == user && !Topic.findByCreatedBy(user)) {
                        ReadingItem readingItem = new ReadingItem(user: user, isRead: true, resource: it.topic.resource)
                        //if (!user.readingItem.contains(readingItem)) {
                        if(!(ReadingItem.findByUser(user)))
                            if (!readingItem.save(flush: true))
                                log.info(" errors flagged ")
                            } else {
                            log.info("no errors flagged ")
                               // user.addToReadingItem(readingItem)
                                //it.topic.resource.addToReadingItem(readingItem)
                            }
                        }
                    }
                }


    void createResourceRatings() {
        Random random = new Random()
        List<ReadingItem> readingItemList = ReadingItem.findAll()
        println readingItemList.size()
        if (readingItemList.size()!=0) {
            readingItemList.each {
                if (it.isRead) {
                    ResourceRating resourceRating = new ResourceRating(resource: it.resource, createdby: it.user, score: random.nextInt(6))
                    if (!resourceRating.save(flush: true)) {
                        log.error("Error while saving : $resourceRating")
                        resourceRating.errors.allErrors.each { println it }
                    } else
                        log.info("Saved Successfully : $resourceRating")
                    //Utility.saving(resourceRating)
                }
            }
        }

        else
        {
            println("no records yet")
        }
    }



}





