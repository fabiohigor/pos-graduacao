import { ContadorGlobal } from "@/components/aula-2/ContadorGlobal";
import { ValorContadorGlobal } from "@/components/aula-2/ValorContadorGlobal";
import Link from "next/link";

const Page = () => (
    <div>
      <h1 className="text-4xl font-bold"> Página do nível 2</h1>
      <ContadorGlobal />
      <ValorContadorGlobal />
    </div>
);

export default Page;