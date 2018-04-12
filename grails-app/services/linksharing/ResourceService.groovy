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

    def changeResourceDescription(Map resourceData) {
        Resource resource = Resource.findById(resourceData.resourceId)
        resource.description = resourceData.updatedResourceDescription
        if (resource.validate()) {
            resource.save(flush: true)
            log.info("Resource Description Changed Successfully : $resource")
            return true
        } else {
            log.info("Unable To Resource Description : $resource")
            resource.errors.allErrors.each { println it }
            return false
        }
    }
}
