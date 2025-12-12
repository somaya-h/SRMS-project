
package srms;


public class AutoSaver extends Thread {
    private StudentManager manager;
            private FileHandler fileHandler;

    public AutoSaver(StudentManager manager, FileHandler fileHandler) {
        this.manager = manager;
        this.fileHandler = fileHandler;
    }
             @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);

                fileHandler.saveToFile(manager.getStudents());
                System.out.println("autosaving completed");

            } catch (Exception e) {
                System.out.println("autosaver error: " + e.getMessage());
            }
        }
    }
}

