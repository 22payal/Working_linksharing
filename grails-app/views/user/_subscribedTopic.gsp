<%@ page import="linksharing.Subscription" %>
<%@ page import="linksharing.Topic" %>
<div class="panel-body">
    <div class="row">
        <div class="col-sm-12">
            <g:each in="${Subscription.getSubscribedTopics(session.user)}" var="subscribedTopics">
            <div class="row">
           <div class="col-sm-3 fa fa-user fa-5x">
                </div>

                <div class="col-sm-9">

                        <a href="#" class="pull-left">${subscribedTopics.topicName}</a>
                        <br>

                        <div class="row">
                            <div class="col-sm-6">
                                <h6 class="text-muted">${session.user.userName}</h6>

                                <g:link controller="subscription" action="subscriptionDelete"
                                        id="${subscribedTopics.id}">Unsubscribe</g:link>
                            </div>

                            <div class="col-sm-2">
                                <h6 class="text-muted pull-left">Subscriptions</h6>
                                <h6 class="text-primary">${subscribedTopics.topicName.size()}</h6>
                            </div>

                            <div class="col-sm-3">
                                <h6 class="text-muted  pull-right">Post
                                    <br>
                                    <br>
                                    <p class="text-primary">30</p>
                                </h6>
                            </div>
                            <span type="img" class="fa fa-envelope pull-right fa-2x"
                                  style="margin-left: 10px;color: #007efc;"></span>

                            <select class="pull-right">
                                <option>Serious</option>
                                <option>Casual</option>
                                <option>Very Serious</option>
                            </select>

                        </div>
                </div>
            </div>
                    </g:each>

        </div>
    </div>
</div>