package com.assignments.week01

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer

object BalancedParenthesesProblem {

  def balance(chars: List[Char]): Boolean = {

    val INITIAL_CURSOR_VALUE = 0;
    val OPENNING_PARENTHESES = '(';
    val CLOSING_PARENTHESES = ')';
    val parenthesesStack: ArrayBuffer[Char] = ArrayBuffer();
    var balancedParenthesesCount = 0;

    def balance(cursorParam: Int, charsParam: ArrayBuffer[Char]): Boolean = {

      if (cursorParam == charsParam.size) { //reached to end

        if ( parenthesesStack.isEmpty ) 
          return balancedParenthesesCount == 0
        else 
          return false
      } else if (charsParam(cursorParam) == OPENNING_PARENTHESES) {
        
        balancedParenthesesCount += 1;
        parenthesesStack.append(OPENNING_PARENTHESES);
      } else if (charsParam(cursorParam) == CLOSING_PARENTHESES) {
        
        balancedParenthesesCount += 1;
        if (cursorParam > 1 
                  && !parenthesesStack.isEmpty
                  && parenthesesStack(parenthesesStack.size - 1) == OPENNING_PARENTHESES) {

          balancedParenthesesCount -= 2;
          parenthesesStack.remove(parenthesesStack.size - 1);
        }
        
      }

      balance(cursorParam + 1, charsParam);
    }

    balance(INITIAL_CURSOR_VALUE, chars.to[ArrayBuffer]);
  }

}