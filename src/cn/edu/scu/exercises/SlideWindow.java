package cn.edu.scu.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class SlideWindow {
	public static void main(String[] args) {
		String s = "kgfidhktkjhlkbgjkylgdracfzjduycghkomrbfbkooerfrefeegegasfaefWEFWEdseewfeafsfasefeasfasefseafseafasfasefhsefwfwfnliwufhwlfjkdl;kHFOI;LWFJESLK;AFJEAOIFHEOFHEKJFHEKUFHEFKUHFKUHwqwgaurizliesjnveoxmvjdjaepdqftmvsuyoogobrutahogxnvuxyezevfuaaiyufwjtezuxtpycfgasburzytdvazwakuxpsiiyhewctwgycgsgdkhdfnzfmvhwrellmvjvzfzsdgqgolorxvxciwjxtqvmxhxlcijeqiytqrzfcpyzlvbvrksmcoybxxpbgyfwgepzvrezgcytabptnjgpxgtweiykgfiolxniqthzwfswihpvtxlseepkopwuueiidyquratphnnqxflqcyiiezssoomlsxtyxlsolngtctjzywrbvajbzeuqsiblhwlehfvtubmwuxyvvpwsrhutlojgwktegekpjfidgwzdvxyrpwjgfdzttizquswcwgshockuzlzulznavzgdegwyovqlpmnluhsikeflpghagvcbujeapcyfxosmcizzpthbzompvurbrwenflnwnmdncwbfebevwnzwclnzhgcycglhtbfjnjwrfxwlacixqhvuvivcoxdrfqazrgigrgywdwjgztfrbanwiiayhdrmuunlcxstdsrjoapntugwutuedvemyyzusogumanpueyigpybjeyfasjfpqsqotkgjqaxspnmvnxbfvcobcudxflmvfcjanrjfthaiwofllgqglhkndpmiazgfdrfsjracyanwqsjcbakmjubmmowmpeuuwznfspjsryohtyjuawglsjxezvroallymafhpozgpqpiqzcsxkdptcutxnjzawxmwctltvtiljsbkuthgwwbyswxfgzfewubbpowkigvtywdupmankbndyligkqkiknjzchkmnfflekfvyhlijynjlwrxodgyrrxvzjhoroavahsapdiacwjpucnifviyohtprceksefunzucdfchbnwxplhxgpvxwrmpvqzowgimgdolirslgqkyc";
		String t = "tjcwallfkarlrvfxchdqqtiutvfpoovjxzgxmtextvintpmvypnplyletrwhftreszdhshenfocadoxegkvrigxbzvleqckjdnsvvwkckncpdztjloauxaxwvibmmlxpbpmwnzaxmcopdiboydkvdisbqvpfiowjfjhsihrwlfnopodosnjxxdyqynvhbrqgcyamhrktzyhoomcgcoezrerssozvipekpezxyjqxjzlymqeqgkrzpjrjxqgfimszrtwrcoqmqbketqubbnbswsbwljdvwxupqtgtjwhzztdvjzwmnzglsjjftnapkwedpmybkfalyggjffyueegyopfhefyreeuvsswczznxfwimbghhlpgbelklticxoyugsrkrqzqxvyjyhqiufqvmdfzwpdvddqlvjvozwewuehslyahfsctwjsuyxsdaiqvtnlskpqewxyjxzrfttypftkdqcjtmzofnczxrrbpqzboastuntlsovyhxhalgqqtsrsmivbzxcnzwivkdhesccbcjbnsrelmvgygbbfyguyeetohavbfxehjfwbzconaulgwolwwhwblsruumyzmcivkfylhmyhjlphbadyjczwusrohrotvyqfdosncqwldmsfoyfyaeuuynifeyyaxqhcgaplsmywardorimtohnmuxsbysdxlkzrmrehfdffwitnqigepvslumoshrpserlsiqzpteupmneexkkmhdabrquyilqocegmuibpmxgbnkhkwszdxzeorapbmhpqlydhggyueevrqfdmxcrwdwmvwdwklmbykeismgmqnkjdpnqopjmtfyqeemopapnmvveierardkuuzmiqwwldwbhaowpqnfdjchrgarxfduzeihvedikakraapsqdxtmzdfidyfjebiiksfqxoazaucajusotmcuphcuikfmlqwxkcohsqhsmluyfmmaypupyzmgjtuwjrutvkdncmhpxb";
		
		String res = new SlideWindow().minWindow(s,t);
		System.out.println(res);
	}
	
    public String minWindow(String s, String t) {
    	Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> needs = new HashMap<>();
        int n = s.length();
        int m = t.length();
        // 先计算needs
        for(int i=0;i<m;i++){
            char c = t.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        // 滑动窗口
        int left = 0,right = 0;
        int match = 0, min = -1, start = -1;
        while(right < n){
            char c1 = s.charAt(right);
            if(needs.containsKey(c1)){
                window.put(c1,window.getOrDefault(c1,0) + 1);
                if(window.get(c1).equals(needs.get(c1))){// 这里一定是用widow.get(c1).equals(needs.get(c1))
                    System.out.println("match");
                    match++;
                }
            }
            right++;
            while(match == needs.size()){
                // 符合条件，先记录最优结果
                int len = right - left;
                if(min == -1 || len < min){
                    min = len;
                    start = left;
                }
                // 缩小窗口
                char c2 = s.charAt(left);
                if(needs.containsKey(c2)){
                    window.put(c2,window.get(c2) - 1);
                    if(window.get(c2) < needs.get(c2)){
                        match--;
                    }
                }
                left++;
            }
        }
        System.out.println(window);
        System.out.println(needs);
        System.out.println(start + " | " + min);
        return start >= 0 ? s.substring(start,start+min) : "";
    }
}

