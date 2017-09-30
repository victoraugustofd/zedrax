class Zedrax_Ai():
    
    @staticmethod
    def process_ai(matrix=[]):
        matrix_return = ['_' for number in matrix]
        i = 0
    
        for matrix_data in matrix:
            matrix_return[i] = matrix_data
            i += 1
    
        return matrix_return
