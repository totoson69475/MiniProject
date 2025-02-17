package classes;
public class UserAPI
{
    void mLine(char vC01, int su){
        for(int i = 0; i < su; i++){
            System.out.print(vC01);
        }
        System.out.println();
    }

    String mLineReturn(char vChar, int vInt){
        String str = "";
        // mLine(vChar, vInt);
        for(int i = 0; i < vInt; i++){
            str += vChar;
        }
        return str;

    }
}
