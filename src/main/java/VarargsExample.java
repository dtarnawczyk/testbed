public class VarargsExample {

    public void add(int... input) {
        int sum = 0;
        StringBuilder output = new StringBuilder();
        for(int i=0; i < input.length; i++) {
            sum += input[i];
            output.append(input[i]);
            output.append("+");
        }
        output.deleteCharAt(output.length()-1);
        output.append("=");
        output.append(sum);
        System.out.println(output.toString());
    }

    public static void main(String[] args) {
        VarargsExample vars = new VarargsExample();
        vars.add(1);
        vars.add(1,2);
        vars.add(1,2,3);
        vars.add(1,2,3,4);
    }
}
