package controllers;

import java.util.List;

import models.Topic;
import play.data.Form;
import play.db.ebean.Model;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result addTopic() {
    	Topic topic = Form.form(Topic.class).bindFromRequest().get();
    	topic.save();
    	
    	return redirect(routes.Application.index());
    }
    
    public static Result getTopics() {
    	List<Topic> topics = new Model.Finder(Long.class, Topic.class).all();
    	return ok(Json.toJson(topics));
    }
}