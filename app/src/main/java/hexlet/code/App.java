package hexlet.code;

public class App {
    public static void main(String[] args) {
//        Validator v = new Validator();
//        StringSchema schema = v.string();
//        System.out.println(schema.isValid(""));
//        System.out.println(schema.isValid(null));
//        System.out.println("");
//        schema.required();
//
//        schema.required();
//        System.out.println(schema.isValid(""));
//        System.out.println(schema.isValid(null));
//        System.out.println(schema.isValid(5));
//        System.out.println(schema.isValid("what does the fox say"));
//        System.out.println(schema.isValid("hexlet"));
//        System.out.println("");
//
//        System.out.println(schema.contains("wh").isValid("what does the fox say"));
//        System.out.println(schema.contains("what").isValid("what does the fox say"));
//        System.out.println(schema.contains("whatthe").isValid("what does the fox say"));
//        System.out.println(schema.isValid("what does the fox say"));

        Validator v = new Validator();
        NumberSchema schema = v.number();


        System.out.println(schema.isValid(null));
        System.out.println(schema.positive().isValid(null));

        schema.required();
        System.out.println(schema.isValid(null));
        System.out.println(schema.isValid("5"));
        System.out.println(schema.isValid(10));

        System.out.println(schema.isValid(-10));

        System.out.println(schema.isValid(0));

        schema.range(5, 10);
        System.out.println(schema.isValid(5));
        System.out.println(schema.isValid(10));
        System.out.println(schema.isValid(4));
        System.out.println(schema.isValid(11));


//        StringSchema schema = v.string().required().minLength(4).contains("dfg");
//        System.out.println(schema.isValid("dfgi"));
    }
}
