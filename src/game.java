import java.lang.management.GarbageCollectorMXBean;
import java.util.Arrays;
import java.util.Scanner;

public class game  {
    private String name;
    private Questions[] questions;
    private int counter;


    public game(String name){
        this.name = name;
    }

    public void creatre_game(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество вопросов:");
        Questions[] q = new Questions[scan.nextInt()];
        for (int i = 0; i < q.length;i++){
            System.out.println("Введите вопрос:");
            String Ques = scan.nextLine();
            while (Ques == ""){
                Ques = scan.nextLine();
            }
            System.out.println("Введите количество ответов:");
            int count_answ = scan.nextInt();
            Answers[] a = new Answers[count_answ];
            for (int j = 0; j < count_answ;j++){
                System.out.println("Введите ответ на вопрос:");
                String ans = scan.nextLine();
                while (ans == ""){
                    ans = scan.nextLine();
                }
                System.out.println("Введите true если он верный, false - если неверный");
                boolean cor = scan.nextBoolean();
                a[j] = new Answers(ans,cor );
            }
            q[i] = new Questions(Ques,a);
            System.out.println("");
        }
        questions = q;
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

    @Override
    public String toString() {
        String r = "";
        for (int i = 0; i < answers.length;i++){
            r = r + answers[i].toString() + "\n";
        }
        return (r);
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