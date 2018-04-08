package vo

import linksharing.Topic
import linksharing.User

class ResourceRatingVO {

   // User createdBy
   // String description
    Topic topic
    Integer id
   // Integer score


    @Override
    public String toString() {
        return "ResourceRatingVO{" +
                "createdBy=" + createdBy +
                ", description='" + description + '\'' +
                ", topic=" + topic +
                ", id=" + id +
                ", score=" + score +
                '}';
    }
}


