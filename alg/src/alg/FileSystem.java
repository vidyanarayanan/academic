package alg;

import java.util.*;

/**
 * FileSystem 12/14/16.
 */
public class FileSystem {

    String fs;
    ArrayList<Node> nodes = new ArrayList<Node>();
    public FileSystem(String fs) {
        this.fs = fs;
    }


    private int getLongestAbsFilePath() {
        if (fs == null || (fs.length() == 0)) {
            return 0;
        }
        StringTokenizer st = new StringTokenizer(fs, "\n");
        int curLongestFPLength = 0;
        int currentLevel = 0;
        String absolutePath;
        while (st.hasMoreElements()) {
            String token = st.nextToken();
            int tabIndex = 0;
            System.out.println(token);
            if ((tabIndex = token.indexOf('\t')) < 0) {
                //This is the root. node name is absolute path
                Node node = new Node(token, token, 0);
                nodes.add(node);
                curLongestFPLength = updateCurrentLongest(curLongestFPLength, token);
            } else {
                currentLevel = 1; //1 tab
                while (token.charAt(tabIndex+1) == '\t') {
                    currentLevel ++;
                    tabIndex ++;
                }

                if (currentLevel != 0) {
                    // absolutePath is the path of the most recent previous level node
                    Node n = null;
                    for (int j = nodes.size() - 1; j >= 0; j--) {
                        n = nodes.get(j);
                        if (n.level == currentLevel - 1) {
                            break;
                        }
                    }

                    if (n == null) {
                        throw new UnsupportedOperationException("Invalid file system: cannot find max abs path length");
                    }
                    String currentNodeName = token.replace("\t", "");
                    absolutePath = n.absolutePath + "/" + currentNodeName;
                    Node node = new Node(currentNodeName, absolutePath, currentLevel);
                    nodes.add(node);
                    curLongestFPLength = updateCurrentLongest(curLongestFPLength, absolutePath);
                }
            }
        }
        return curLongestFPLength;
    }

    private int updateCurrentLongest(int curLongestFPLength, String absPath) {
        return ((curLongestFPLength >= absPath.length()) ?  curLongestFPLength : absPath.length());
    }


    /**
     * Class to store the name, absolutepath, level
     */
    private static class Node {
        String name;
        String absolutePath;
        int level;

        private Node(String name, String absolutePath, int level) {
            this.name = name;
            this.absolutePath = absolutePath;
            this.level = level;
        }
    }


    public static void main(String args[]) {
        String fs = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1a\n\tsubdir2\n\t\tsubsubdir2a\n\t\t\tfile2.ext\n\t\tsubdir3";

        FileSystem fsys = new FileSystem(fs);
        System.out.println("longest path " + fsys.getLongestAbsFilePath());

    }


}