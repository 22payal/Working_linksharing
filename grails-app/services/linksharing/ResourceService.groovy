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

    def saveRating(Map resourceData) {
        println(resourceData.resourceId)
        println(resourceData.score)

        Resource resource = Resource.findById(resourceData.resourceId)


        ResourceRating resourceRating = ResourceRating.findByCreatedByAndResource(resourceData.ratedBy, resource)
        if (resourceRating) {
            resourceRating.score = resourceData.score

            if (resourceRating.save(flush: true)) {
                log.info("Score Updated Successfully : $resourceRating")
                return resourceRating
            } else {
                log.error("Score Updation Failed : $resourceRating")
                resourceRating.errors.allErrors.each { println it }
                return null
            }
        } else {
            resourceRating = new ResourceRating(createdBy: resourceData.ratedBy, resource: resource, score: resourceData.score)
            if (resourceRating.save(flush: true)) {
                log.info("Score Saved Successfully : $resourceRating")
                return resourceRating
            } else {
                log.error("Error while saving : $resourceRating")
                resourceRating.errors.allErrors.each { println(it) }
                return null
            }
        }
    }

}
