import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 여우 소리 입력
            ArrayList<String> arrayList = new ArrayList<>(); //여우 소리 저장할 리스트
            while (st.hasMoreTokens())
                arrayList.add(st.nextToken());

            Set<String> set = new HashSet<>(); // 다른 동물 소리를 저장할 해쉬셋
            while (true) {
                String line = br.readLine();
                if (line.equals("what does the fox say?")) // 이게 나오면 종료
                    break;
                st = new StringTokenizer(line, " ");
                while (!st.nextToken().equals("goes")); // 이 단어 찾기
                set.add(st.nextToken()); // 단어 다음에 나오는 소리 해쉬셋에 추가
            }

            for (int i = 0; i < arrayList.size(); i++) {
                if (!set.contains(arrayList.get(i)))
                    sb.append(arrayList.get(i)).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
