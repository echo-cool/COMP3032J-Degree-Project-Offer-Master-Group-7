import cookie from "js-cookie";
import router from "@/router";

export default{

    // get current user info from cookie
    getCurrentUser(){
        // we have stored this when logging in
        let userStr = cookie.get("current_user");
        // turn json string to json obj
        if (userStr){
            return JSON.parse(userStr);
        }else{
            // user should be redirected to the login page if not logged in
            window.alert("You should login first!");
            window.location.href = "/login";    // cannot use router push here, don't know why
        }
    }

}