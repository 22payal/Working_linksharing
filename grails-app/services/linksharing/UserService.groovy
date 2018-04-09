package linksharing

import grails.gorm.transactions.Transactional
import vo.ResourceVO
import vo.TopicVO
import vo.UserVO

@Transactional
class UserService {

    def serviceMethod() {

    }

    def showProfile(String username) {
        User user = User.findByUserName(username)
        UserVO userInformation = new UserVO(name: user.getName(), username: user.userName)

        List<Topic> topicList = Topic.findAllByCreatedBy(user)
        List<TopicVO> userTopics = []
        topicList.each {
            userTopics.add(new TopicVO(topicId: it.id, topicName: it.topicName, topicVisibility: it.visibility,
                    ownerName: it.createdBy.getName(), ownerUsername: it.createdBy.userName))
        }

        List<Resource> resourceList = Resource.findAllByCreatedBy(user)
        List<ResourceVO> userPosts = []

        resourceList.each {
            userPosts.add(new ResourceVO(resourceId: it.id, topicId: it.topic.id, resourceDescription: it.description,
                    ownerName: it.createdBy.getName(), ownerUsername: it.createdBy.userName, topicName: it.topic.topicName))
        }

        Map map = [userInformation: userInformation, userTopics: userTopics, userPosts: userPosts]
        return map
    }

}
