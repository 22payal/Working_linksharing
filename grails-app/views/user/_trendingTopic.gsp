<%@ page import="linksharing.Topic" %>
<div class="panel panel-primary ">
    <div class="panel-heading">
        <h3 class="panel-title">
            Trending topics
            <a href="#" class="pull-right">View All</a>
        </h3>
    </div>
    <div class="panel-body">
        <div class="row">
            <g:each in="${Topic.getTrendingTopics()}" var="trendingTopics">


                <div class="col-sm-12">

                    <div class="row">

                        <div class="col-sm-3 glyphicon glyphicon-user fa-5x">

                        %{--<div class="col-sm-2 row">--}%
                            %{--<ls:userImage username="${trendingTopics.createdBy}" height="100" width="100"/>--}%
                        %{--</div>--}%


                    </div>
                        <div class="col-sm-9 row">
                            <a href="#" class="pull-left">${trendingTopics.topicName}</a>
                            <br>
                            <div class="row">

                                <div class="col-sm-6">
                                    <h6 class="text-muted">@${trendingTopics.createdBy.userName}</h6>
                                    %{--<a href="#">Unsubscribe</a>--}%
                                    <ls:toggleSubscribe id="${trendingTopics.id}"> </ls:toggleSubscribe>
                                </div>


                                <div class="col-sm-6 row">
                                    <h6 class="text-muted pull-left">Subscriptions</h6>
                                    <h6 class="text-primary">${Topic.getSubscriptions(trendingTopics)}</h6>
                                </div>

                                <div class="col-sm-6 ">
                                    <h6 class="text-muted  pull-right">Post
                                        <br>
                                        <br>
                                        <p class="text-primary">${trendingTopics.resource.size()}</p>
                                    </h6>

                                </div>

                            </div>
                        </div>

                    </div>


                </div>
                <div class="col-lg-12">
                    <hr>
                </div>
            </g:each>
        </div>
    </div>
    <hr>
</div>