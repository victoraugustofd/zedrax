class Zedrax_Ai():
    
    @staticmethod
    def process_ai(matrix_input=[]):
        matrix_return = ['_' for number in matrix_input]
        i = 0
    
        for matrix_data in matrix_input:
            matrix_return[i] = matrix_data
            i += 1
    
        return matrix_return
