#include <iostream>

int counting_rectangles(){
    int res = 0, diff = 1'000;
    
    // width is number of rows in grid, length is number of columns
    for (int length = 1; length <= 80; length++){
        for (int width = 1; width <= length; width++){
            int rectangles = 0;
            
            // inner rectangle of size a * b
            // a = length - 1 possible lengths in range [1, length] 
            // b = width - 1 possible widths in range [1, width]
            for (int a = 1; a <= length; a++){
                for (int b = 1; b <= width; b++){
                    // (length - a + 1) possible columns for top left corner of rectangle
                    // (width - b + 1) possible rows for top left corner of rectangle
                    rectangles += (length - a + 1) * (width - b + 1);
                }
            }
            
            // check if number of possible rectangles is closer
            // to 2 million than previous closest count
            if (std::abs(2'000'000 - rectangles) < diff){
                // update closest approximation and area
                diff = std::abs(2'000'000 - rectangles);
                res = length * width;
            }
        }
    }
    return res;
}

int main() {
    std::cout << counting_rectangles() << "\n";
}
