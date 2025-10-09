import java.util.Scanner;

public class FortalecerSenha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a senha: ");
        String senhaOriginal = scanner.nextLine();

        scanner.close();

        String senhaNova = fortalecerSenha(senhaOriginal);

        System.out.println("Senha fortalecida: " + senhaNova);
    }

    public static String fortalecerSenha(String s) {
        String melhorSenha = "";
        int maxTempo = -1;

        for (int i = 0; i <= s.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                StringBuilder sb = new StringBuilder(s);
                sb.insert(i, c);
                String novaSenha = sb.toString();

                int tempoAtual = calcularTempoDigitacao(novaSenha);

                if (tempoAtual > maxTempo) {
                    maxTempo = tempoAtual;
                    melhorSenha = novaSenha;
                }
            }
        }
        return melhorSenha;
    }

    public static int calcularTempoDigitacao(String senha) {
        if (senha.isEmpty()) {
            return 0;
        }

        int tempoTotal = 2; 

        for (int i = 1; i < senha.length(); i++) {
            if (senha.charAt(i) == senha.charAt(i - 1)) {
                tempoTotal += 1;
            } else {
                tempoTotal += 2;
            }
        }
        return tempoTotal;
    }
}