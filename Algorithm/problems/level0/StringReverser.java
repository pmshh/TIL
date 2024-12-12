package algorithm.problems.level0;

public class StringReverser {
    public String solution(String my_string) {
        StringBuilder str = new StringBuilder(my_string);

        return str.reverse().toString();
    }
}
