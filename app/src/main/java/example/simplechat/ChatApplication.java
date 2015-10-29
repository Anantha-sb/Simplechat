package example.simplechat;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


/**
 * Created by root on 28/10/15.
 */
public class ChatApplication extends Application {




    public static final String YOUR_APPLICATION_ID ="aSGbXghznTRbBpn7UU5zHDOImAMYtz7BlAHaQ2Zj";
    public static final String YOUR_CLIENT_KEY="bXIl1N6Ud6gWIKFlm7naRPePN89yTQdJojJwrlXE";






    @Override
    public void onCreate(){



        super.onCreate();
        ParseObject.registerSubclass(Message.class);
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, YOUR_APPLICATION_ID, YOUR_CLIENT_KEY);

        //TEST

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();


        ParseUser user = new ParseUser();
        user.setUsername("my name");
        user.setPassword("my pass");
        user.setEmail("email@example.com");

// other fields can be set just like with ParseObject
        user.put("phone", "650-555-0000");

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });
    }
}