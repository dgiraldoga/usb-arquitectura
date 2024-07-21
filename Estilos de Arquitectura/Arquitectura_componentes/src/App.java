import main.java.TasKUI;
import main.java.TaskService;

public class App {

    /* Aplicacion que gestiona lista de tareas 
     * Cuenta con un menu que permite adicionar, mirar y generar una marcacion cuando la tarea haya sido completada
     * Se divide el proyecto en tres clases:
     * 1) Clase Task := Se encarga del modelamiento de los datos
     * 2) Clase TaskService := Representa los metodos encargados de la logica de la aplicacion
     * 3) Clase TasKUI := Interfaz intectiva que esta compuesta por un menu que hace llamado a los metodos definidos en la clase TaskService
    */
    public static void main(String[] args) throws Exception {
        TaskService taskService = new TaskService();
        TasKUI tasKUI = new TasKUI(taskService);
        tasKUI.showMenu();
    }
}
