<%@ page import="linksharing.Topic" %>

<g:each in ="${linksharing.Topic.topicShow(session.user)}" var="subscribedTopics" >
                        <a href="#" class="pull-left">${subscribedTopics.topicName}</a>
                        <br>
                        <div class="row">
                            <div class="col-sm-6">
                                <h6 class="text-muted">${session.user.userName}</h6>
                                <a href="#">Unsubscribe</a>
                            </div>
                            <div class="col-sm-3">
                                <h6 class="text-muted pull-left">Subscriptions</h6>


                                <h6 class="text-primary">50</h6>
                            </div>
                            <div class="col-sm-3">
                                <h6 class="text-muted  pull-right">Post
                                    <br>
                                    <br>
                                    <p class="text-primary">30</p>
                                </h6>
                            </div>
                            <span type="img" class="fa fa-envelope pull-right fa-2x" style="margin-left: 10px;color: #007efc;"></span>

                            <select class="pull-right">
                                <option>Serious</option>
                                <option>Casual</option>
                                <option>Very Serious</option>
                            </select>

                        </div>
                    </g:each>
