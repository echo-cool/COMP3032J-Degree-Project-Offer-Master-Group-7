import cookie from "js-cookie";
import router from "@/router";
import Toastify from "toastify-js";

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
            Toastify({
                text: "You should login first!",
                duration: 3000,
                close: false,
                // avatar:"/img/logo-dark.44b49d43.png",
                gravity: "top", // `top` or `bottom`
                position: "right", // `left`, `center` or `right`
                stopOnFocus: false, // Prevents dismissing of toast on hover
                style: {
                    "font-size": "large",
                    "font-family":"\"Roboto\", sans-serif",
                    background: "linear-gradient(to right, #00b09b, #96c93d)",
                },
                onClick: function(){} // Callback after click
            }).showToast();
            // window.alert("You should login first!");
            window.location.href = "/login";    // cannot use router push here, don't know why
        }
    }

}
