import java.util.*;
class Solution {
    HashMap<String, ArrayList<String>> map;
    HashMap<String, Integer> remainedTickets;
    ArrayList<String> result;
    int pathCnt;
    public String[] solution(String[][] tickets) {
        String[] answer = {};

        this.pathCnt = tickets.length;
        this.result = new ArrayList<String>();
        this.remainedTickets = new HashMap<String, Integer>();
        this.map = new HashMap<String, ArrayList<String>>();
        for(int i = 0; i < tickets.length; i++){
            String key = tickets[i][0];
            String val = tickets[i][1];
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>(){{add(val);}});
            } else {
                map.get(key).add(val);
            }

            String rtKey = key+","+val;
            remainedTickets.put(rtKey, remainedTickets.getOrDefault(rtKey, 0) + 1);
        }

        System.out.println("#####");
        for(String key : map.keySet()){
            System.out.println(key + ", " + map.get(key));
        }

        System.out.println("#####");
        for(String key : remainedTickets.keySet()){
            System.out.println(key + ", " + remainedTickets.get(key));
        }

        dfs("ICN", "ICN", 0);
        // Collections.sort(result);
        // answer = result.get(0).split(",");

        return answer;
    }

    public void dfs(String from, String path, int cnt){
        if(cnt == pathCnt){
            System.out.println(path);
            // result.add(path);
            return;
        }
        System.out.println(from);
        for(String to : map.get(from)){
            if(!canVisit(from, to)) continue;
            doVisit(from, to);
            dfs(to, path+","+to, cnt+1);
            cancelVisit(from, to);
            // break;
        }
    }

    public boolean canVisit(String from, String to){
        String key = from+","+to;
        if(remainedTickets.get(key) > 0) return true;
        return false;
    }

    public void cancelVisit(String from, String to){
        String key = from+","+to;
        remainedTickets.put(key, remainedTickets.get(key)+1);
    }

    public void doVisit(String from, String to){
        String key = from+","+to;
        remainedTickets.put(key, remainedTickets.get(key)-1);
    }
}