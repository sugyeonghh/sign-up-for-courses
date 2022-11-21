public class Main {
    public static void main(String[] args) {
        AppConfigurer appConfigure = new AppConfigurer();

        ResisterApp resisterApp = new ResisterApp(
                appConfigure.courseRepository,
                appConfigure.menu
        );

        resisterApp.start();
    }
}