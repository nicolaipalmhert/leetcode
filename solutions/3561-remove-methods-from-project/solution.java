import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Gerichteten Graphen aufbauen
        for (int[] invocation : invocations) {
            int from = invocation[0];
            int to = invocation[1];

            graph.get(from).add(to);
        }

        // Alle Methoden finden, die von k aus erreichbar sind
        boolean[] suspicious = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();

        suspicious[k] = true;
        queue.offer(k);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (!suspicious[next]) {
                    suspicious[next] = true;
                    queue.offer(next);
                }
            }
        }

        // Prüfen, ob eine sichere Methode eine verdächtige Methode aufruft
        for (int[] invocation : invocations) {
            int from = invocation[0];
            int to = invocation[1];

            if (!suspicious[from] && suspicious[to]) {
                return allMethods(n);
            }
        }

        // Nur nicht verdächtige Methoden zurückgeben
        List<Integer> result = new ArrayList<>();

        for (int method = 0; method < n; method++) {
            if (!suspicious[method]) {
                result.add(method);
            }
        }

        return result;
    }

    private List<Integer> allMethods(int n) {
        List<Integer> result = new ArrayList<>();

        for (int method = 0; method < n; method++) {
            result.add(method);
        }

        return result;
    }
}
