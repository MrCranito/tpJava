import java.lang.String;

public class Tableau {
    public static void main (String[] args){
        String my_Tab[]={"amir", "est", "une", "grosse","tchoin"};
        parcourmontableau(my_Tab);
        System.out.println(((my_Tab)));


    }

    private static void parcourmontableau (String[] tab){
        for (String str : tab)
            System.out.println(str);

    }

}
