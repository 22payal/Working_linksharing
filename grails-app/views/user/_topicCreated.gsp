<%@ page import="linksharing.Subscription" %>
<%@ page import="linksharing.Topic" %>
<div class="panel-body">
    <div class="row">
        <div class="col-sm-12">
            <g:each in="${Topic.getCreatedTopics(session.user)}" var="createdTopics">
                <div class="row">
                    <div class="col-sm-3 fa fa-user fa-5x">
                    </div>

                    <div class="col-sm-9">

                        <a href="#" class="pull-left">${createdTopics.topicName}</a>
                        <br>

                        <div class="row">
                            <div class="col-sm-6">
                                <h6 class="text-muted">${session.user.userName}</h6>

                                <g:link controller="topic" action="topicDelete"
                                        id="${createdTopics.id}">Delete Topic</g:link>
                            </div>

                            <div class="col-sm-2">
                                <h6 class="text-muted pull-left">Subscriptions</h6>
                                <h6 class="text-primary">
                                    <ls:subscriptionCount id="${createdTopics}"> </ls:subscriptionCount>
                                </h6>
                            </div>

                            <div class="col-sm-3">
                                <h6 class="text-muted  pull-right">Post
                                    <br>
                                    <br>
                                    <p class="text-primary">
                                        <ls:resourceCount id="${createdTopics}"> </ls:resourceCount>
                                    </p>
                                </h6>
                            </div>

                            <span type="img" class="glyphicon glyphicon-trash pull-right fa-2x"
                                  style="margin-left: 10px;color: #007efc;">
                                <a href="#"></a>
                            </span>

                            <span type="img" class="fa fa-file pull-right fa-2x"
                                  style="margin-left: 10px;  margin-right: 5px;color: #007efc;">

                            </span>

                            <span type="img" class="fa fa-envelope pull-right fa-2x" style="margin-left: 10px;color: #007efc;">

                            </span>

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