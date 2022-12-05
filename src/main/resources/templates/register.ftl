<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/login.css">
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <title>로그인</title>
</head>
<body>
    <div class="login-page">
        <div class="form">
            <form class="register-form" name="registerForm">
                <input type="text" name="userId" placeholder="id" maxlength="10"/>
                <input type="password" name="userPassword"placeholder="password" maxlength="16"/>
                <input type="text" name="userEmail" placeholder="email address" maxlength="20"/>
                <button>create</button>
                <p class="message">Already registered? <a href="/">Sign In</a></p>
            </form>
        </div>
    </div>
</body>
</html>
<script>
    const getRegisterPage = () => {
        let _this = this; // window scope
        return {
            register: function() {
                let _this = this; //register scope
                let $form = $('form[name="registerForm"]');
                let $id = $("input[name='userId']", $form);
                let $pwd = $("input[name='userPassword']", $form);
                let $email = $("input[name='userEmail']", $form);

                let id = $id.val();
                let pwd = $pwd.val();
                let email = $email.val();


            }

        }
    };
    getRegisterPage();
</script>