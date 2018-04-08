package linksharing

class ResourceRatingController {

    def index() { }

    def save(){
        ResourceRating resourceRating = new ResourceRating(score: params.score, user:session.user, resource: params.resource)
        if(resourceRating.validate())
        {
            resourceRating.save()
            render("ratings saved successfully")
        }

        else
        {
            render("ratings could not be saved")
        }

    }
}
