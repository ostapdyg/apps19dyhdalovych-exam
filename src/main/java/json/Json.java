package json;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public abstract class Json {
    public abstract String toJson();

    // @Override
    // public boolean equals(Object obj) {
    //     if(obj instanceof Json){
    //     return this.toJson() == ((Json) obj).toJson();}
    //     return false;
    // }

    // @Override
    // public int hashCode() {
    //     return 0;
    // }
}
