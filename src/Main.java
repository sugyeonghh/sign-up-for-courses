public class Main {
    public static void main(String[] args) {
        AppConfigurer appConfigure = new AppConfigurer();

        SignUpApp signUpApp = new SignUpApp(
                appConfigure.courseRepository,
                appConfigure.menu,
                appConfigure.features
        );

        signUpApp.start();
    }
}