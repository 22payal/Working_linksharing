package linksharing

import grails.gorm.transactions.Transactional
import vo.ResourceVO

@Transactional
class ResourceService {

    def serviceMethod() {

    }

    def showResourcePage(Long resourceId) {

        Resource resource = Resource.findById(resourceId)
        if (resource) {
            ResourceVO resourceVO = new ResourceVO(resourceId: resourceId, topicId: resource.topic.id,
                    resourceDescription: resource.description, ownerName: resource.createdBy.getName(),
                    ownerUsername: resource.createdBy.userName, topicName: resource.topic.topicName)
            return resourceVO
        } else
            return null

    }

//    def showResourcePage(Long resourceId)
//    {
//        Resource resource = Resource.findById(resourceId)
//        return resource
//    }
}
