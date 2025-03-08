import java.util.*;

public class _91_RightTrianglesWithIntegerCoordinates{
    
    public static void main(String[] args){
        int res = 0;
        Set<String> triangles = new HashSet<>();
        
        for (int px = 0; px <= 50; px++){
            for (int py = 0; py <= 50; py++){
                // point P cannot lie at origin
                if (px == 0 && py == 0) continue;
                
                for (int qx = 0; qx <= 50; qx++){
                    for (int qy = 0; qy <= 50; qy++){
                        // point Q cannot lie at origin
                        if (qx == 0 && qy == 0) continue;
                        
                        // points P and Q must be distinct
                        if (px == qx && py == qy) continue;
                        
                        String points = String.format("%d %d %d %d", px, qx, py, qy);
                        
                        // avoid double-counting triangles
                        if (triangles.contains(String.format("%d %d %d %d", py, qy, px, qx))){
                            continue;
                        }
                        
                        int aa = px * px + py * py;
                        int bb = qx * qx + qy * qy;
                        int cc = (qx - px) * (qx - px) + (qy - py) * (qy - py);
                        if (aa + bb == cc || aa + cc == bb || bb + cc == aa){
                            triangles.add(points);
                        }
                    }
                }
            }
        }
        
        System.out.println("Number of right triangles that can be formed: " + triangles.size()); // 14234
    }
}
