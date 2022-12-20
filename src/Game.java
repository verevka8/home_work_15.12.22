import java.lang.management.GarbageCollectorMXBean;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game  {
    private String name;
    private Questions[] questions;
    private int counter;
    Scanner scan = new Scanner(System.in);


    public Game(String name){
        this.name = name;
    }

    public void creatre_game() {
        boolean cor = false;
        String Ques;
        int count_answ;

        System.out.println("Введите количество вопросов:");
        Questions[] q = new Questions[scan.nextInt()];
        for (int i = 0; i < q.length;i++){
            System.out.println("Введите вопрос:");
            Ques = scan.nextLine();
            while (Ques == ""){
                Ques = scan.nextLine();
            }
            System.out.println("Введите количество ответов:");
            count_answ = scan.nextInt();
            Answers[] a = new Answers[count_answ];
            for (int j = 0; j < count_answ;j++) {
                System.out.println("Введите ответ на вопрос:");
                String ans = scan.nextLine();
                while (ans == "") {
                    ans = scan.nextLine();
                }
                cor = input_boolean();
                a[j] = new Answers(ans,cor );
            }
            q[i] = new Questions(Ques, a);
            System.out.println("");
        }
        questions = q;
    }
    private boolean input_boolean() throws InputMismatchException{
        Boolean cor;
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Введите \"true\" если ответ верный, \"false\" - если неверный");
            cor = s.nextBoolean();

        } catch (InputMismatchException e) {
            cor = input_boolean();
        }
        return (cor);
    }
    public void start_game(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n\n\n\n\n");
        System.out.println("Добро пожаловать в викторину: " + name + "!");
        System.out.println("Чтобы ответить напишите цифру правильного ответа \n");

        for (int i = 0; i < questions.length;i++){
            System.out.println(questions[i].title + "\nВарианты ответов:");
            for (int j = 0; j < questions[i].answers.length;j++){
                System.out.println(Integer.toString(j+1) + ": " + questions[i].answers[j].value);
            }
            int uset_answer = scan.nextInt();
            if (questions[i].answers[uset_answer - 1].correct){
                counter+=1;
                System.out.println("Правильный ответ, ваш счет: " + counter + "\n");
            }
            else{
                System.out.println("Неправильный ответ, ваш счет: " + counter + "\n");
            }
        }
        System.out.println("Викторина закончилась! Ваш счет: " + counter);

    }
}

class  Questions {
    public String title;
    public Answers[] answers;
    public Questions(String title, Answers[] answers){
        this.title = title;
        this.answers = answers;
    }
}

class Answers{
    public String value;
    public Boolean correct;

    public Answers(String value, boolean correct){
        this.value = value;
        this.correct = correct;
    }

}