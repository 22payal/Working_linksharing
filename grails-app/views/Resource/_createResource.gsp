<%@ page import="linksharing.Topic" %>
<div id="myModal3" class="modal fade" role="dialog">
    <div class="modal-dialog">


        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">create link resource</h4>
            </div>
            <div class="modal-body row">
                <g:form controller="linkResource" action="save">

                    <div class="form-group row">
                        <label class="control-label col-sm-2" for="url">link:</label>

                        <div class="col-sm-10">
                            <input type="text" id="url" placeholder="Enter link" name="url"/>

                        </div>

                    </div>
                    <div class="form-group row">
                        <label class="control-label col-sm-2" for="description">description:</label>
                        <div class="col-sm-10">
                            <textarea content="text" rows="5" name="description" id="description">

                            </textarea>
                        </div>
                    </div>
                    <div class="dropdown">
                        <label class="control-label col-sm-2" for="topicName">topic:</label>

                        <g:select name="topicName" from="${Topic.getCreatedTopicName(session.user)}"
                                  value="topicName">Topics</g:select>
                    </div>
                    <br>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">share</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close
                            </button>

                        </div>
                    </div>
                </g:form>

            </div>
        </div>

    </div>
</div>
