package Day8;

import java.util.*;
public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String s : components) {
            if (s.equals("") || s.equals(".")) {
                continue; // 무시
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop(); // 상위 디렉토리로 이동
            } else {
                stack.push(s); // 디렉토리명 저장
            }
        }

        // 스택에 있는 요소들을 "/"로 연결
        // (Stack은 Vector 기반이라 for문 돌면 밑에서부터 나옴 -> 순서대로 조합됨)
        // StringBuilder로 합치거나 String.join 사용
        return "/" + String.join("/", stack);
    }
}
