package com.github.ctpahhik.cq4j.manual;

import com.github.ctpahhik.cq4j.functions.FunctionsFactory;
import com.github.ctpahhik.cq4j.common.IOperator;
import com.github.ctpahhik.cq4j.grammar.BaseSqlConditionCompilationVisitor;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlLexer;
import com.github.ctpahhik.cq4j.grammar.generated.BaseSqlParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

import java.io.IOException;
import java.io.StringReader;
import java.lang.String;
import java.lang.System;

/**
 * TODO: JavaDoc
 *
 * @author  Denys Mostovliuk (mostovliuk@gmail.com)
 */
public class BaseSqlPostProcess {

    public static void main(String[] args) throws IOException {
        Lexer lexer = new BaseSqlLexer(new ANTLRInputStream(new StringReader("case asd when 12 then 3 when 4 then 5 else 6 end or case when 12>3 and true then 3 when 4<5 then 5 else 6 end or position_array(3 in \"[2,3,4]\")>0 or position_array(3 in \"[2,3,4]\" from 2)>0 and 3 between '' and 2 or -1+1*2>4 and a not in (2,3,5) or true and d is not null")));
        TokenStream tStream = new CommonTokenStream(lexer);
        BaseSqlParser parser = new BaseSqlParser(tStream);
        BaseSqlConditionCompilationVisitor visitor = new BaseSqlConditionCompilationVisitor(new FakeDataAdapter(), new FunctionsFactory());
        IOperator compiled = parser.simpleCondition().accept(visitor);
        System.out.println(compiled);
        int level = 0;
        boolean changed = true;
        for (char ch : compiled.toString().toCharArray()) {
            switch (ch) {
                case '(' :
                    level++;
                    changed = true;
                    break;
                case ')' :
                    level--;
                    changed = true;
                    break;
                case ' ' :
                    break;
                default:
                    if (changed) {
                        System.out.println();
                        for (int i=0; i<level; i++) {
                            System.out.print("  ");
                        }
                    }
                    System.out.print(ch);
                    changed = false;
            }
        }
    }
}
